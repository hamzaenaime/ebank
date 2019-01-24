/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import DAO.Dao;
import Exceptions.AccountException;
import static MODELS.Operation.conn;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nafar
 */
public class ClientOperation extends Operation {

    /**
     *
     * @param compte_src
     * @param compte_dst
     * @param motif
     * @param montant
     * @return
     */
    public static boolean createClientOperation(int compte_src, int compte_dst, String motif, float montant) {
        conn = Dao.getConnection();//id_client,
        try {
            Account.debiter(montant, compte_src);
            if (Account.crediter(montant, compte_dst)) {
                int id_operation = Operation.createOperation(compte_src, compte_dst, motif, montant);
                String req = "insert into operation_client (id_operation,id_client) values (?,?)";
                PreparedStatement prep = conn.prepareStatement(req);
                prep.setInt(1, id_operation);//Client.getCin()
                prep.setString(2, Client.getCin());
                int action = prep.executeUpdate();
                return action > 0;
            }
        } catch (AccountException ex) {
            System.out.print(ex.getMessage());
        } catch (SQLException ex) {
            System.out.print("error lors de l'insertion dans la table operation_client :" + ex.getMessage());
        }
        return false;
    }

}
