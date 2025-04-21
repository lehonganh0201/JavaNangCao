-- Bảng Accounts
CREATE TABLE Accounts (
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);

-- Bảng ClientConnectionInfo
CREATE TABLE ClientConnectionInfo (
    pc_name VARCHAR(100) NOT NULL,
    ip_address VARCHAR(50) NOT NULL,
    port INT NOT NULL,
    status VARCHAR(50),
    start_time VARCHAR(50),
    end_time VARCHAR(50),
    PRIMARY KEY (pc_name, ip_address, port)
);