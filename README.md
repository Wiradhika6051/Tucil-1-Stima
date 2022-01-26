# Tucil-1-Stima
Sebuah program untuk menyelesaikan permainan Word Search Puzzle

# Identitas Author
- Nama: Fawwaz Anugrah Wiradhika Dharmasatya
- NIM:13520086
- Jurusan:Teknik Informatika

# Daftar Isi
1. [Deskripsi Singkat](#deskripsi-singkat)
2. [Requirement dan Instalasi](#requirement-dan-instalasi)
3. [Cara Penggunaan](#cara-penggunaan)
   - [Troubleshooting](#troubleshooting)

# Deskripsi Singkat
*Word Search Puzzle* adalah sebuah permainan dimana pemain diberikan sebuah matriks berisi kumpulan huruf dan daftar kata-kata yang perlu dicari di dalam matriks tersebut. Pola kata dalam matriks tersebut bisa ke arah atas, kanan atas, kanan, kanan bawah, bawah, kiri bawah, kiri, maupun kiri atas. Program ini adalah sebuah aplikasi  yan ditulis dalam bahasa Java untuk menyelesaikan permainan *Word Search Puzzle* menggunakan algoritma *brute force*. Algoritma ini akan memeriksa semua kemungkinan delapan arah pada tiap elemen matriks untuk menemukan kata-kata yang terdapat pada list kata dan menampilkan hasil berupa matriks kata yang sudah ditandai dimana kata-kata yang perlu dicari berada.

# Requirement dan Instalasi
- Untuk dapat menjalankan aplikasi ini, pastikan dulu Java sudah terinstall di perangkat.
- Penampilan hasil pencarian di aplikasi ini menggunakan ANSI coloring. Namun, tidak semua terminal dapat menampilkan ANSI coloring secara otomatis, terutama jika menggunakan command prompt. Untuk sistem operasi Windows, cara mengatur agar ANSI coloring bisa ditampilkan di terminal adalah sebagai berikut:
 1. Buka "Registry Editor".
 2. Pergi ke folder HKEY_CURRENT_USER.
 3. Masuk ke folder Console.
 4. Klik kanan lalu buat pilih **New > DWORD (32 bit) Value**.
 5. Buat sebuah file dengan nama **VirtualTerminalLevel** lalu isi dengan value 1.

# Cara Penggunaan
 1. Buat sebuah file yang berisi matriks dan list kata seperti yang diminta soal. 
    - Tiap elemen pada baris matriks dipisahkan oleh spasi. 
    - Berikan sebuah baris kosong diantara baris terakhir matriks dengan kata pertama pada list kata. 
    - Tiap baris pada list kata hanya terdiri dari satu kata.
 2. Simpan file tersebut di folder **test**.
 3. Pergi ke folder **bin**.
 4. Jalankan **run.bat**.
 5. Tuliskan nama file yang ingin dibuka beserta ekstensinya (misal: **small-1.txt**).
 6. Tunggu program bekerja dan hasilnya akan ditampilkan ke layar beserta list kata yang sudah ditemukan terurut berdasarkan urutan penemuan, waktu algoritma bekerja, jumlah    perbandingan sampai program selesai, serta jumlah kata yang berhasil ditemukan.

 ## Troubleshooting
 Jika file **run.bat** tidak bisa dijalankan, maka pada folder **bin** disediakan semua file .class yang tinggal dijalankan dengan membuka shell / command prompt dan   mengetikkan:
 `java Main Color Parser ParserResult QueryResult Solver`
