

segment .data ; segmento de uma sessão
	LF equ 0xA ; Line feed, agora LF vai se comportar como '0xA'
	; EAX
	SYS_EXIT	equ 0x1 ; Codigo de chamada para finalizar o nosso programa
	SYS_READ	equ 0x3 ; Operação de leitura
	SYS_WRITE	equ 0x4 ; Operação de escrita
	; EBX	
	RET_EXIT equ 0x0 ; Operação realizada com sucesso
	STD_IN eq 0x0 ; Entrada padrão
	STD_OUT equ 0x1 ; Saida padrão

section .data

