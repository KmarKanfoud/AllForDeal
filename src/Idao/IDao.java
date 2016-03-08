/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import java.util.List;

/**
 *
 * @author Super
 * @param <S>
 */
public interface IDao<S> {
        void add(S s);

    void update(S s);

    void removeById(int id);

    List<S> findAll();

    S findById(int id);
    
}
