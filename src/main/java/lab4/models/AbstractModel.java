package lab4.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractModel {
    public AbstractModel() {

    }
    public AbstractModel(String[] info){
        if (info.length > 0) {
            id = Integer.parseInt(info[0]);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
