package net.restassured.demo.reusable;

public enum Resource {

    gets("/maps/api/place/get/json"),
    adds("/maps/api/place/add/json"),
    deletes("/maps/api/place/delete/json");

    private String resource;

    Resource(String resource) {
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }

}
