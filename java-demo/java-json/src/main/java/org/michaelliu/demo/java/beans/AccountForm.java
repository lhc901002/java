package org.michaelliu.demo.java.beans;

import com.github.reinert.jjschema.Attributes;

/**
 * Created by Michael on 2016/10/26.
 */
@Attributes(title="Account", description="A product from Acme's catalog")
public class AccountForm {

    @Attributes(required=true, description="The unique identifier for a product")
    private Long id;

    @Attributes(required=true, description="account name", minLength = 4, readonly = false)
    private String name;

    public AccountForm() {
    }

    public AccountForm(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
