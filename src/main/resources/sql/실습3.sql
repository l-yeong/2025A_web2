    CREATE TABLE books (
        id INT NOT NULL,
        title VARCHAR(255) NOT NULL,
        stock INT NOT NULL DEFAULT 0,
        PRIMARY KEY (id)
    );

    -- 2. 대출 기록 테이블
    CREATE TABLE rentals (
        id INT NOT NULL,
        book_id INT NOT NULL,
        member VARCHAR(100) NOT NULL,
        rent_date DATETIME DEFAULT NOW(),
        return_date DATETIME NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (book_id) REFERENCES books(id)
    );

    -- 3. 샘플 데이터 (책 목록)
    INSERT INTO books (id, title, stock) VALUES (1, '자바의 정석', 3);
    INSERT INTO books (id, title, stock) VALUES (2, '스프링 인 액션', 2);
    INSERT INTO books (id, title, stock) VALUES (3, '토비의 스프링', 1);
    INSERT INTO books (id, title, stock) VALUES (4, '리액트 교과서', 5);

    -- 4. 샘플 데이터 (대출 기록)
    INSERT INTO rentals (id, book_id, member) VALUES (1, 1, '홍길동');

    -- 5. 확인용 조회 쿼리
    SELECT * FROM books;
    SELECT * FROM rentals;