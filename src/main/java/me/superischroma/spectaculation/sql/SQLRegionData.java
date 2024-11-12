package me.superischroma.spectaculation.sql;

import me.superischroma.spectaculation.region.Region;
import me.superischroma.spectaculation.region.RegionType;
import org.bukkit.Location;
import java.util.ArrayList;
import java.util.List;

public class SQLRegionData
{
    public boolean exists(String regionName)
    {
        return false;
    }

    public Region get(String name)
    {
        return null;
    }

    public List<Region> getAllOfType(RegionType type)
    {
        return new ArrayList<>();
    }


    public List<Region> getAll()
    {
        return new ArrayList<>();
    }

    public Region create(String name, Location firstLocation, Location secondLocation, RegionType type)
    {
        return null;
    }

    public void save(Region region)
    {

    }

    public void delete(Region region)
    {

    }

    public int getRegionCount()
    {
        return 0;
    }
}