package BeansDB;

import java.io.*;
import java.sql.*;

public class BeanCRUD extends BeanConnection implements Serializable
{
    private ResultSet resultset;
    private Statement instruction;
    private Statement instructionIN;


    public BeanCRUD() throws IOException, ClassNotFoundException, SQLException
    {
    }

    public synchronized void Insert(String sql_instruction) throws SQLException {
        getInstruction().execute(sql_instruction);
    }

    public synchronized ResultSet Select(String sql_instruction) throws SQLException
    {
        ResultSet rs = getInstruction().executeQuery(sql_instruction);
        return rs;
    }

    public synchronized void Update(String sql_instruction) throws SQLException {
        getInstruction().executeUpdate(sql_instruction);
    }

    public synchronized void Delete(String sql_instruction) throws SQLException {
        getInstruction().executeQuery(sql_instruction);
    }


    public Statement getInstructionIN() {
        return instructionIN;
    }

    public void setInstructionIN(Statement instructionIN) {
        this.instructionIN = instructionIN;
    }
    public Statement getInstruction() {
        return instruction;
    }

    public void setInstruction(Statement s) {
        instruction = s;
    }

    public ResultSet getResultset() {
        return resultset;
    }

    public void setResultset(ResultSet rs) {
        resultset = rs;
    }
}
