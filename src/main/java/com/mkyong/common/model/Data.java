package com.mkyong.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data
{
    @JsonProperty("name")
    private String name;
    @JsonProperty("actors")
    private String actors;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getActors()
    {
        return actors;
    }
    public void setActors(String actors)
    {
        this.actors = actors;
    }
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Data [name=");
        builder.append(name);
        builder.append(", actors=");
        builder.append(actors);
        builder.append("]");
        return builder.toString();
    }
    
    
}
