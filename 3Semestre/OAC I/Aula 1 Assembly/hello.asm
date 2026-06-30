;Compilar - transformar o programa para linguagem máquina
;	nasm -f win32 nome-do-projeto.asm -o nome-do-projeto.obj
;Linkeditar - transformar o programa em linguagem de mapa para executável
;	gcc nome-do-projeto.obj -o nome-do-projeto.exe -mconsole

section .data
    msg db "Hello World!"
	tam equ $- msg ; equivalente a fazer 'tam equ 0xC'

section .text

global _start

_start:
    mov EAX, 0x4
	mov EBX, 0X1
	mov ECX, msg
	mov EDX, tam
	int 0x80

;Para rodar:
;nasm -f win32 file.asm -o file.obj
;gcc file.obj -o file.exe -mconsole
;.\hello.exedw