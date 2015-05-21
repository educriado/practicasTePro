-- Javier Fumanal Idocin - 684229
-- Eduardo Criado Mascaray - 662844
module ArrayPolynomial where

--Devuelve el polinomio x+0
x :: [Double]
x = [1.0,0.0]

--Devuelve un polinomio compuesto unicamente del termino independiente c
coef :: Double->[Double]
coef c = [c]

--Deriva un polinomio
pderv :: [Double]->[Double]
pderv (x)= init (polinomMap (mderv) x)

--Deriva un monomio
mderv :: Double ->Integer ->Double
mderv m i=m*(fromIntegral i)

--Evalua un polinomio con el valor dado
peval :: [Double] -> Double -> Double
peval p x=sum (polinomMap (meval x) p)

--Evalua un monomio. x es el valor dado, i es el exponente y c el coeficiente
meval :: Double -> Double -> Integer -> Double
meval x c i=c*(x**(fromInteger i))

--Aplica a cada monomio de una polinomio la función f.
polinomMap :: (Double -> Integer -> Double)->[Double]->[Double]
polinomMap f p=polinomMapAux f p 0

polinomMapAux :: (Double -> Integer -> Double)->[Double]->Integer->[Double]
polinomMapAux f [] i=[]
polinomMapAux f (p) i= (polinomMapAux f (init p) (i+1)) ++ [(f (last p) i)]

--Suma una lista de polinomios
padd :: [[Double]] -> [Double]
padd (p:ps) = foldl pbadd p ps

--Suma binaria de dos polinomios. (Suma dos polinomios)
pbadd :: [Double]->[Double]->[Double]
pbadd [] [] = []
pbadd [] (m) = m
pbadd (p) [] = p
pbadd (p) (m) = (pbadd (init p) (init m)) ++ [(last p)+(last m)]

--Multiplica una lista de polinomios
pmul ::  [[Double]] -> [Double]
pmul (p:ps) = foldl (pbmul) p ps 

--Multiplicacion binaria de polinomios (Multiplica dos polinomios)
pbmul :: [Double]->[Double]->[Double]
pbmul (p) (m) =  padd (pbmulAux 0 p m)

--Devuelve una lista con los polinomios resultado de multiplicar cada monomio del primero por el otro polinomio
pbmulAux :: Integer->[Double]->[Double]->[[Double]]
pbmulAux i [] (m) = []
pbmulAux i (p) (m) = ((mmul (last p) i m) : (pbmulAux (i+1) (init p) m))

--Multiplica un polinomio por un monomio de exponente i
mmul ::  Double->Integer->[Double]->[Double]
mmul m i [] = if (i<=0) then [] else ([0] ++ mmul m (i-1) [])
mmul m i (p) =  (map (* m) p) ++ mmul m (i) []






