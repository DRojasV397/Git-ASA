import java.util.List;
import java.util.Stack;
import java.util.HashMap;


public class ASA implements Parser{
    private int i = 0;
    private boolean hayErrores = false;
    private final List<Token> tokens;

    public ASA(List<Token> tokens){
        this.tokens = tokens;
    }

    @Override
    public boolean parse() {
        Stack<Integer> pila = new Stack<>();
        pila.push(0);

        HashMap<Integer, HashMap<Object, Object>> tabla = new HashMap<>();
        tabla.put(0, new HashMap<Object, Object>(){{
            put(TipoToken.SELECT, 2);
            put("Q", 1);
        }});
        tabla.put(1, new HashMap<Object, Object>(){{
            put(TipoToken.EOF, "aceptar");
        }});
        tabla.put(2, new HashMap<Object, Object>(){{
            put(TipoToken.DISTINCT, 4);
            put(TipoToken.IDENTIFICADOR, 9);
            put(TipoToken.ASTERISCO, 6);
            put("D", 3);
            put("P", 5);
            put("A", 7);
            put("A2", 8);
        }});
        tabla.put(3, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, 19);
        }});
        tabla.put(4, new HashMap<Object, Object>(){{
            put(TipoToken.IDENTIFICADOR, 9);
            put(TipoToken.ASTERISCO, 6);
            put("P", 15);
            put("A", 7);
            put("A2", 8);
        }});
        tabla.put(5, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R3");
        }});
        tabla.put(6, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R4");
        }});
        tabla.put(7, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R5");
        }});
        tabla.put(8, new HashMap<Object, Object>(){{
            put(TipoToken.COMA, 10);
            put("A1", 18);
            put(TipoToken.FROM, "R8");
        }});
        tabla.put(9, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R11");
            put(TipoToken.COMA, "R11");
            put(TipoToken.PUNTO, 12);
            put("A3", 11); 
        }});
        tabla.put(10, new HashMap<Object, Object>(){{
            put(TipoToken.IDENTIFICADOR, 9);
            put("A", 14);
            put("A2", 8);
        }});
        tabla.put(11, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R9");
            put(TipoToken.COMA, "R9");
        }});
        tabla.put(12, new HashMap<Object, Object>(){{
            put(TipoToken.IDENTIFICADOR, 13);
        }});
        tabla.put(13, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R10");
            put(TipoToken.COMA, "R10");
        }});
        tabla.put(14, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R7");
        }});
        tabla.put(15, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R2");
        }});
        tabla.put(18, new HashMap<Object, Object>(){{
            put(TipoToken.FROM, "R6");
        }});
        tabla.put(19, new HashMap<Object, Object>(){{
            put(TipoToken.IDENTIFICADOR, 21);
            put("T", 29);
            put("T2", 20);
        }});
        tabla.put(20, new HashMap<Object, Object>(){{
            put(TipoToken.COMA, 23);
            put(TipoToken.EOF, "R14");
            put("T1", 28);
        }});
        tabla.put(21, new HashMap<Object, Object>(){{
            put(TipoToken.IDENTIFICADOR, 26);
            put(TipoToken.COMA, "R17");
            put(TipoToken.EOF, "R17");
            put("T3", 25);
        }});
        tabla.put(23, new HashMap<Object, Object>(){{
            put(TipoToken.IDENTIFICADOR, 21);
            put("T", 24);
            put("T2", 20);
        }});
        tabla.put(24, new HashMap<Object, Object>(){{
            put(TipoToken.EOF, "R13");
        }});
        tabla.put(25, new HashMap<Object, Object>(){{
            put(TipoToken.COMA, "R15");
            put(TipoToken.EOF, "R15");
        }});
        tabla.put(26, new HashMap<Object, Object>(){{
            put(TipoToken.EOF, "R16");
        }});
        tabla.put(28, new HashMap<Object, Object>(){{
            put(TipoToken.EOF, "R12");
        }});
        tabla.put(29, new HashMap<Object, Object>(){{
            put(TipoToken.EOF, "R1");
        }});

        HashMap<String, Integer> reducciones = new HashMap<>();
        reducciones.put("R1", 4);
        reducciones.put("R2", 2);
        reducciones.put("R3", 1);
        reducciones.put("R4", 1);
        reducciones.put("R5", 1);
        reducciones.put("R6", 2);
        reducciones.put("R7", 2);
        reducciones.put("R8", 0);
        reducciones.put("R9", 2);
        reducciones.put("R10", 2);
        reducciones.put("R11", 0);
        reducciones.put("R12", 2);
        reducciones.put("R13", 2);
        reducciones.put("R14", 0);
        reducciones.put("R15", 2);
        reducciones.put("R16", 1);
        reducciones.put("R17", 0);

        int estadoActual;
        Object accion;
        Object simboloActual;
        simboloActual = tokens.get(i).tipo;
        int popPila;

        while(true){ 
            estadoActual = pila.peek();
            accion = tabla.get(estadoActual).get(simboloActual);
            
            if(accion == null){
                hayErrores = true;
                break;
            }
            else if(accion.equals("aceptar")){
                break;
            }
            else if(accion instanceof Integer){
                
            } else if(accion instanceof String){
                
            }
        }
        if(hayErrores){
            System.out.println("Error Sintactico");
            return false;
        }
        else{
            System.out.println("La sintaxis es correcta");
            return true;
        }
    }
}
