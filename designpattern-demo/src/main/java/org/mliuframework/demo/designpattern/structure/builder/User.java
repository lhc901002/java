package org.mliuframework.demo.designpattern.structure.builder;

/**
 * Created by michael on 7/3/2016.
 */
public class User {

    private Long id;

    private String name;

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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder {

        private Long id;

        private String name;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

}
