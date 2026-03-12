package service;

/**
 * static: generador de IDs simple.
 */
public class IdGenerator {
    public static int currentLibro = 100;
    public static int currentRevista = 100;
    public static int currentUsuario = 100;
    public static int currentPrestamo = 100;

    public static String nextId(char typeId) {
        int newId = 0;
        switch (typeId){
            case 'L':
                newId = currentLibro++;
                break;
            case 'R':
                newId = currentRevista++;
                break;
            case 'U':
                newId = currentUsuario++;
                break;
            case 'P':
                newId = currentPrestamo++;
                break;
            }
        return typeId + "" + newId;
        }
    }
