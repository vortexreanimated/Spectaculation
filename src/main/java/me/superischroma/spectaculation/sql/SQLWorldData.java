package me.superischroma.spectaculation.sql;

import org.bukkit.World;

public class SQLWorldData
{
    public boolean exists(World world)
    {
        return false;
    }

    public boolean existsID(int id)
    {
        return false;
    }

    public int getWorldID(World world)
    {
        return -1;
    }

    public World getWorld(int id)
    {
        return null;
    }

    public int getWorldCount()
    {
        return 0;
    }
}