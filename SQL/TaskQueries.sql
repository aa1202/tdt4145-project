USE FilmDB;
# a
SELECT rolle FROM SkuespillerI as S INNER JOIN Person as P ON S.fnr = P.fnr WHERE Navn="Ola Halvorsen";

# b
SELECT M.* FROM Person P 
	INNER JOIN SkuespillerI S 
		ON P.fnr = S.fnr 
	INNER JOIN Media M 
		ON S.MediaID = M.MediaID 
	WHERE P.navn="Ola Halvorsen";

    
SELECT S.Navn, Sjanger, count(H.SjangerID) AS Total FROM Selskap S
	INNER JOIN EierAvMedia E 
		ON E.SelskapID = S.SelskapID
	INNER JOIN Media M 
		ON M.MediaID = E.MediaID
	INNER JOIN HarSjanger H 
		ON H.MediaID = M.MediaID
	INNER JOIN Sjanger SJ 
		ON SJ.SjangerID = H.SjangerID
	GROUP BY S.navn, Sjanger
    ORDER BY Sjanger, Total DESC;
    