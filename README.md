# REST API áp dụng kiến trúc Sạch 
Kiến trúc Sạch (Clean Architecture) là một phương pháp thiết kế phần mềm nhằm tách biệt các phần của ứng dụng để đảm bảo tính mở rộng, dễ bảo trì và kiểm thử. Trong mô hình này, các thành phần của ứng dụng được tổ chức theo nhiều lớp, với mỗi lớp có một trách nhiệm riêng biệt, giúp giảm thiểu sự phụ thuộc giữa các thành phần.
![image](https://github.com/user-attachments/assets/849e0fba-a2fb-4d75-8a8f-75bf57d77619)

## Overview
 Base sourcecode này là một ví dụ về cách xây dựng REST API trong ứng dụng Android theo nguyên tắc Clean Architecture. Clean Architecture giúp tách biệt các phần của ứng dụng, từ đó dễ dàng bảo trì và mở rộng. 

Sử dụng các công nghệ như Retrofit, Dagger Hilt, ViewModel, Room và Kotlin Coroutines để tối ưu hóa quy trình lấy dữ liệu và quản lý phụ thuộc.

  ![image](https://github.com/user-attachments/assets/4725cadc-e1c1-4671-8a40-44c5ec9167fd)

  ## Công Nghệ Sử Dụng
- **Retrofit**: Thư viện để thực hiện các yêu cầu HTTP và lấy dữ liệu từ API.
- **Dagger Hilt**: Thư viện Dependency Injection để quản lý phụ thuộc.
- **Coroutines**: Để xử lý các tác vụ bất đồng bộ.
- **Room**: Thư viện để lưu trữ dữ liệu cục bộ (nếu cần thiết).
- **MVVM**: Kiến trúc Model-View-ViewModel để tách biệt logic giao diện.
- Databinding.
   
  
