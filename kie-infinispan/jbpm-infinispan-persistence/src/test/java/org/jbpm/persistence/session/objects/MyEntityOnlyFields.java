package org.jbpm.persistence.session.objects;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
public class MyEntityOnlyFields implements Serializable {

	private static final long serialVersionUID = 510l;
	
	@Id @DocumentId @Field
    public Long id;
	@Field
    public String test;
	@Field
	public String type = "myEntityOnlyFields";

    public MyEntityOnlyFields(){}

    public MyEntityOnlyFields(String string) {
        this.test= string;
    }
    
    public String toString(){
        return "VARIABLE: " + id + " - " + test;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyEntityOnlyFields other = (MyEntityOnlyFields) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.test == null) ? (other.test != null) : !this.test.equals(other.test)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 41 * hash + (this.test != null ? this.test.hashCode() : 0);
        return hash;
    }
    
}
