# changgou

Unable to access 'https://github.com/tianyu-1993/changgou.git/': OpenSSL SSL_read: SSL_ERROR_SYSCALL, errno 10054
git config --global http.sslVerify "false"

Eureka 访问页面出现红色字体提醒

系统在三种情况下会出现红色加粗的字体提示：
1.在配置上，自我保护机制关闭

RENEWALS ARE LESSER THAN THE THRESHOLD. THE SELF PRESERVATION MODE IS TURNED OFF.THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.
2.自我保护机制开启了

EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE

NOT BEING EXPIRED JUST TO BE SAFE.
3.在配置上，自我保护机制关闭了，但是一分钟内的续约数没有达到85% ， 可能发生了网络分区，会有如下提示

THE SELF PRESERVATION MODE IS TURNED OFF.THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.
git config http.postBuffer 524288000
git config http.sslVerify "false"