Quy trình chạy CORBA:

1. Cài đặt JDK 1.8.0_202 ![8u462b08](https://www.azul.com/downloads/?package=jdk#zulu)
    - Nếu tồn tại nhiều bản trong máy, sẽ cần một vài cmd để có thể chuyển đổi giữa các phiên bản JDK.
        Thông qua folder ![ConfigEnv](ConfigEnv)
        Chạy file ![ConfigEnv/switchJdk8.bat]() để chuyển qua phiên bản cũ.
        Kiểm tra lại bằng cmd: java -version 
        Kết quả mong muốn: java 1.8.0

2. Biên dịch:
    - Các file code (bao gồm Server, Client, ORB) đều phải được biên dịch trước, sau đó sẽ khởi chạy đồng loạt
    - Khởi tạo dependencies biên dịch IDL (dành cho ORB): -> Bỏ qua nếu folder CORBA/idl/MessageApp đã tồn tại
        cd ".\CORBA\idl"
        idlj -fall Message.idl
    - Biên dịch tất cả .java file:
        cd ".\CORBA"
        javac -Xlint:-options -d build idl/MessageApp/*.java src/server/*.java src/client/*.java

3. Khởi chạy:
    - Đăng ký ORB tại port 1050
        tnameserv -ORBInitialPort 1050
    - Kết nối server tới ORB (port 1050)
        cd "CORBA"
        java -cp build serverSide.Server -ORBInitialPort 1050 -ORBInitialHost localhost
    - Khởi chạy Client và gửi tin nhắn tới Server
        cd "CORBA"
        java -cp build clientSide.Client -ORBInitialPort 1050 -ORBInitialHost localhost  