#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

#define BUFFER_SIZE 4096

void error(const char* msg) {
    perror(msg);
    exit(1);
}

void print_specific_header_info(char* response) {
    char* headers[] = { "Server", "Date", "Content-Type", "Transfer-Encoding", "Connection", "Expires", "Content-Language", NULL };
    char* line;
    int i;

    line = strtok(response, "\r\n");
    while (line != NULL) {
        for (i = 0; headers[i] != NULL; i++) {
            if (strncmp(line, headers[i], strlen(headers[i])) == 0) {
                printf("%s\n", line);
                break;
            }
        }
        line = strtok(NULL, "\r\n");
    }
}

int main(int argc, char* argv[]) {
    int sockfd, portno = 80, n;
    struct sockaddr_in serv_addr;
    struct hostent* server;
    char buffer[BUFFER_SIZE];
    char* body;
    unsigned int total_received = 0;

    if (argc != 2) {
        fprintf(stderr, "usage %s hostname\n", argv[0]);
        exit(0);
    }

    char* hostname = strtok(argv[1], "/");
    char* path = strtok(NULL, "") ? : "/";

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0)
        error("ERROR opening socket");

    server = gethostbyname(hostname);
    if (server == NULL) {
        fprintf(stderr, "ERROR, no such host\n");
        exit(0);
    }

    printf("IP Address: %s\n", inet_ntoa(*(struct in_addr*)server->h_addr));

    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    memcpy(&serv_addr.sin_addr.s_addr, server->h_addr, server->h_length);
    serv_addr.sin_port = htons(portno);

    if (connect(sockfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr)) < 0)
        error("ERROR connecting");

    sprintf(buffer, "GET /%s HTTP/1.1\r\nHost: %s\r\nConnection: close\r\n\r\n", path, hostname);
    n = write(sockfd, buffer, strlen(buffer));
    if (n < 0)
        error("ERROR writing to socket");

    printf("Sent HTTP header:\n%s", buffer);
    printf("Amount of data sent: %d bytes\n", n);

    memset(buffer, 0, BUFFER_SIZE);
    n = read(sockfd, buffer, BUFFER_SIZE - 1);
    if (n < 0)
        error("ERROR reading from socket");

    buffer[n] = '\0';
    print_specific_header_info(buffer);

    FILE* fp = fopen("output.html", "w");
    if (fp == NULL) error("ERROR opening file");

    int header_found = 0;
    do {
        if (!header_found) {
            body = strstr(buffer, "\r\n\r\n");
            if (body) {
                body += 4;
                header_found = 1;
                fprintf(fp, "%s", body);
                total_received += strlen(body);
            }
        }
        else {
            fprintf(fp, "%s", buffer);
            total_received += n;
        }
        memset(buffer, 0, BUFFER_SIZE);
        n = read(sockfd, buffer, BUFFER_SIZE - 1);
    } while (n > 0);

    if (n < 0) error("ERROR reading from socket");
    fclose(fp);
    close(sockfd);

    printf("Amount of data received: %u bytes\n", total_received);
    return 0;
}
