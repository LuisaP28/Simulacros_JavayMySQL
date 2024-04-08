package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class ConfigDB {
        //Variable que va a contener el estado de la conexión
        static Connection objConnection = null;

        //Metodo para abrir la conexión entre Java y la base de datos

        public static Connection openConnection(){
            try {
                //Class forname permite obtener o implementar el driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //Creamos variables con nuestras credenciales de la base de datos
                String url = "jdbc:mysql://bgwczwmfjps24x2v6ayr-mysql.services.clever-cloud.com:3306/bxqzuxb6geadlg9ardhj";
                String user = "uwcngnzq8dtbichj";
                String password = "zOp05sFrfWDbmCJ87bTs";

                //Establecemos la conexión
                objConnection = (Connection) DriverManager.getConnection(url,user,password);
                System.out.println("Me conecté perfectamente!!!!");

            }catch (ClassNotFoundException e){
                System.out.println("Error >> Driver no Instalado");
            }catch (SQLException e){
                System.out.println("Error >> No se pudo establecer una conexión con la BD"+ e.getMessage());
            }

            return objConnection;

        }


        public static void closeConnection(){
            try {
                //Si hay una conexión activa, la cerramos
                if (objConnection != null) objConnection.close();
                System.out.println("se finalizó la conexión con éxito");

            }catch (SQLException e){
                System.out.println("ERROR: "+ e.getMessage());
            }
        }

    }
