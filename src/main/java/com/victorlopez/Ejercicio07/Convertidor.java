package com.victorlopez.Ejercicio07;

import java.util.HashMap;

public class Convertidor {
    private HashMap<Moneda,Double> cambio;
    private double usd,gbp,inr,aud,cad,ars,bob,clp,vez,crc,cup,dop,mxn;
    public Convertidor() {
        cambio = new HashMap<>();
        usd = 1.09;
        gbp = 0.84;
        inr = 78.0;
        aud = 1.66;
        cad = 1.45;
        ars = 67.26;
        bob = 7.5;
        clp = 885.47;
        vez = 3741.61;
        crc = 621.25;
        cup = 1.09;
        dop = 57.99;
        mxn = 20.87;
        addMonedas();
    }
    public void addMonedas(){
        cambio.put(Moneda.USD,usd);
        cambio.put(Moneda.GBP,gbp);
        cambio.put(Moneda.INR, inr);
        cambio.put(Moneda.AUD, aud);
        cambio.put(Moneda.CAD, cad);
        cambio.put(Moneda.ARS, ars);
        cambio.put(Moneda.BOB, bob);
        cambio.put(Moneda.CLP, clp);
        cambio.put(Moneda.VEZ, vez);
        cambio.put(Moneda.CRC,crc);
        cambio.put(Moneda.CUP,cup);
        cambio.put(Moneda.DOP,dop);
        cambio.put(Moneda.MXN,mxn);
    }
    public double convertir(double c, Moneda m){
        double resultado = Double.MIN_VALUE;
        switch (m){
            case USD:
                resultado =  c * cambio.get(Moneda.USD);
                break;
            case GBP:
                resultado = c * cambio.get(Moneda.GBP);
                break;
            case INR:
                resultado = c* cambio.get(Moneda.INR);
                break;
            case AUD:
                resultado = c* cambio.get(Moneda.AUD);
                break;
            case CAD:
                resultado = c * cambio.get(Moneda.CAD);
                break;
            case ARS:
                resultado = c * cambio.get(Moneda.ARS);
                break;
            case BOB:
                resultado = c * cambio.get(Moneda.BOB);
                break;
            case CLP:
                resultado = c* cambio.get(Moneda.CLP);
                break;
            case VEZ:
                resultado = c * cambio.get(Moneda.VEZ);
                break;
            case CRC:
                resultado = c * cambio.get(Moneda.CRC);
                break;
            case CUP:
                resultado = c * cambio.get(Moneda.CUP);
                break;
            case DOP:
                 resultado = c * cambio.get(Moneda.DOP);
                break;
            case MXN:
                resultado = c * cambio.get(Moneda.MXN);
                break;
        }
        return resultado;
    }
}
