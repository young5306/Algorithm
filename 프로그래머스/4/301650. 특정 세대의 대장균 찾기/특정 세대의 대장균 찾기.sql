SELECT three.ID
FROM ECOLI_DATA three
JOIN 
    (SELECT two.ID
    FROM ECOLI_DATA two
    JOIN 
        (SELECT ID
        FROM ECOLI_DATA
        WHERE PARENT_ID IS NULL) one
    ON two.PARENT_ID = one.ID) two
ON three.PARENT_ID = two.ID