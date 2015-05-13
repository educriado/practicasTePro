module TupleListPolynomial where

	-- crear monomio x
	x :: [(Double, Integer)]
	x = [(1.0, 1)]

	-- devuelve polinomio con termino independiente c
	coef :: Double -> [(Double, Integer)]
	coef c = [(c, 0)]

	-- calcula la derivada 
	pderv :: [(Double, Integer)] -> [(Double, Integer)]
	pderv [(_, 0)] = []
	pderv ((c, e):xs) = (c * (fromIntegral e), e - 1) : pderv xs

	-- evalua el polinomio p para el valor x
	peval :: [(Double, Integer)] -> Double -> Double
	peval [] _ = []
	peval ((c, e):xs) x = c * (^) x e + peval xs x

	
	-- suma dos polinomios y devuelve otro polinomio
	paddbin :: [(Double, Integer)] -> [(Double, Integer)] -> [(Double, Integer)]
	-- primero monomios mismo exponente y distinto
	paddbin [a@(c, e):resto1] [b@(d, f):resto2]
		| e == f = (c + d, e) : paddbin resto1 resto2
		| e > f = a : b : paddbin resto1 resto2
		| e < f = b : a : paddbin resto1 resto2


	-- suma todos los polinomios en la lista lp y devuelve el resultado
	padd :: [[(Double, Integer)]] -> [(Double, Integer)]
	padd 




