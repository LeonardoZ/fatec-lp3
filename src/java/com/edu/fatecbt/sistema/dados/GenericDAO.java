package com.edu.fatecbt.sistema.dados;

import com.edu.fatecbt.usuario.Usuario;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public abstract class GenericDAO<T> {

    private Class<?> classe = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];

    public Session getSession() {
        return HibernateUtil.getSession();
    }

    protected Class<?> getClasse() {
        return classe;
    }

    public void salvar(T entity) {
        try {
            getSession().saveOrUpdate(entity);
            getSession().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(T t) {
        getSession().delete(t);
    }

    public Optional<T> get(Integer cod) {
        
        
        return Optional.ofNullable((T) getSession().get(getClasse(), cod));
    }
    
    
    public Usuario fazLogin(String login, String senha){
    
        return (Usuario) getSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("senha",senha))
                .uniqueResult();
               
                
    }
    

    public List<T> selecionaTodos() {
        return Collections.checkedList(getSession().createCriteria(getClasse()).list(), getClasse());
    }

}
