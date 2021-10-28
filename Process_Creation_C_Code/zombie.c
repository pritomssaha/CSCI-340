#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
int main()
{
    // Fork returns process id
    // in parent process
    pid_t child_pid = fork();
  
    // Parent process 
    if (child_pid > 0)
        sleep(50);
  
    // Child process
    else if(child_pid==0){
        prinf("I am the child with pid %d and my parent has ppid %d",child_pid, getpid());
        exit(0);
    }
    prinf(" I am the parent and my id is %d ",getpid());
  
    return 0;
}