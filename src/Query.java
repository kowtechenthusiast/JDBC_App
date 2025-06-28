public class Query {
        private static String insert = "INSERT INTO employee VALUES(?,?,?,?)";
        private static String update = "UPDATE employee SET name=? WHERE id=?";
        private static String delete = "DELETE FROM employee WHERE id=?";
        private static String read = "SELECT * FROM employee";

        public static String getInsertQuery(){
            return insert;
        }
        public static String getUpdateQuery(){
            return update;
        }
        public static String getDeleteQuery(){
            return delete;
        }
        public static String getReadQuery(){
            return read;
        }
    }
