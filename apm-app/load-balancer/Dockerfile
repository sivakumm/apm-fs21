FROM nginx:latest
COPY nginx.conf /etc/nginx/nginx.conf

RUN apt update && apt -y install keepalived

COPY keepalived-master.conf /etc/keepalived/keepalived.conf
RUN chmod -x /etc/keepalived/keepalived.conf
