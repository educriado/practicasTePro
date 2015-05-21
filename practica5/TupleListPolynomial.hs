-- Javier Fumanal Idocin - 684229
-- Eduardo Criado Mascaray - 662844
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
peval [] _ = 0.0 
peval ((c, e):xs) x = c * ((^) x e) + peval xs x

-- suma todos los polinomios en la lista lp y devuelve el resultado
padd :: [[(Double, Integer)]] -> [(Double, Integer)]
padd (s:sp) = foldl (pbadd) s sp

-- suma dos polinomios y devuelve otro polinomio
pbadd :: [(Double, Integer)] -> [(Double, Integer)] -> [(Double, Integer)]
pbadd [] b = b 
pbadd a [] = a 	
-- primero monomios mismo exponente y distinto
pbadd (a@(c, e):resto1) (b@(d, f):resto2)
	| e == f = (c + d, e) : pbadd resto1 resto2
	| e > f = a : pbadd resto1 (b:resto2)
	| e < f = b : pbadd (a:resto1) resto2

-- multiplica una lista de polinomios
pmul :: [[(Double, Integer)]] -> [(Double, Integer)]
pmul (x:xs) = foldl (pbmul) x xs 

-- multiplicacion de dos polinomios
pbmul :: [(Double,Integer)]->[(Double,Integer)]->[(Double,Integer)]
pbmul [] _ = []
pbmul (x:xs) (b) = pbadd (mmul x b) (pbmul xs b)

-- multiplica un polinomio por un monomio 
mmul ::  (Double,Integer) -> [(Double,Integer)] -> [(Double,Integer)]
mmul _ [] = [] 
mmul m@(a, b) ((c, e):xs) = (a * c, b + e) : mmul m xs  



