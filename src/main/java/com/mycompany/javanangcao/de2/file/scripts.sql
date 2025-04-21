CREATE TABLE Student (
    student_id VARCHAR(20) PRIMARY KEY,
    full_name VARCHAR(100),
    date_of_birth VARCHAR(20),
    gender VARCHAR(10),
    foreign_languages VARCHAR(100),
    gpa FLOAT
);
-- Thêm dữ liệu mẫu
INSERT INTO Student (student_id, full_name, date_of_birth, gender, foreign_languages, gpa) VALUES
('SV001', 'Nguyễn Văn A', '2002-01-15', 'Nam', 'Tiếng Anh, Tiếng Nhật', 3.6),
('SV002', 'Trần Thị B', '2001-08-23', 'Nữ', 'Tiếng Anh', 3.8),
('SV003', 'Lê Hoàng C', '2002-11-10', 'Nam', 'Tiếng Pháp', 3.2),
('SV004', 'Phạm Minh D', '2000-05-05', 'Nữ', 'Tiếng Trung', 3.0),
('SV005', 'Đỗ Hải E', '2003-07-20', 'Nam', 'Tiếng Đức, Tiếng Anh', 3.9);