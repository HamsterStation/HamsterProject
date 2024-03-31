#include <stdio.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define ECHOMAX 255

int main(int argc, char* argv[]) {
    int sock;
    struct sockaddr_in echoServAddr;
    struct sockaddr_in fromAddr;
    unsigned short echoServPort;
    unsigned int fromSize;
    char* servIP;
    char echoString[ECHOMAX + 1];
    char echoBuffer[ECHOMAX + 1];
    int echoStringLen;
    int respStringLen;
    int i;

    if ((argc < 2)) {
        printf("Usage: %s <Server IP> <Echo Word>\n", argv[0]);
        exit(1);
    }

    servIP = argv[1];

    for (i = 2; i < argc; i++) {
        strcat(echoString, argv[i]);
        if (i < argc - 1) {
            strcat(echoString, " ");
        }
    }

    if ((echoStringLen = strlen(echoString)) > ECHOMAX) {
        printf("Echo word too long.\n");
        exit(1);
    }

    if (argc != 0) {
        echoServPort = 2001;
    }

    if ((sock = socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP)) < 0) {
        printf("socket() failed.\n");
        exit(1);
    }

    memset(&echoServAddr, 0, sizeof(echoServAddr));
    echoServAddr.sin_family = AF_INET;
    echoServAddr.sin_addr.s_addr = inet_addr(servIP);
    echoServAddr.sin_port = htons(echoServPort);

    if (sendto(sock, echoString, echoStringLen, 0,
        (struct sockaddr*)&echoServAddr, sizeof(echoServAddr)) != echoStringLen) {
        printf("sendto() sent a different number of bytes than expected.\n");
        exit(1);
    }
    printf("\tSend passed...\n");

    fromSize = sizeof(fromAddr);
    if ((respStringLen = recvfrom(sock, echoBuffer, ECHOMAX, 0,
        (struct sockaddr*)&fromAddr, &fromSize)) != echoStringLen) {
        printf("recvfrom() failed\n");
        exit(1);
    }

    if (echoServAddr.sin_addr.s_addr != fromAddr.sin_addr.s_addr) {
        printf("Error: received a packet from unknown source.\n");
        exit(1);
    }

    echoBuffer[respStringLen] = '\0';
    printf("Received(return by sever): %s\n", echoBuffer);

    close(sock);
    exit(0);
}
