package com.cdp.appenclase.Procesos;

public class Transacciones
{
    /* Nombre de la BDD */
    public static final String NameDataBase = "DBPM01";

    /* Creacion de tablas de la BD */

    public static final String tablaEmpleados = "empleados";

    /* Campos de la tabla empleados */

    public static final String id = "id";
    public static final String nombre = "nombre";
    public static final String apellido = "apellido";
    public static final String edad = "edad";
    public static final String correo = "correo";


    /* Sentencias SQL para crear tablas */

    public static final String CreateTableEmpleados = "CREATE TABLE empleados "+
                                                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        "nombre TEXT, apellido TEXT, edad INTEGER, "+
                                                        "correo TEXT)";

    public static final String DropTableEmpleados = "DROP TABLE IF EXISTS empleados";
}
