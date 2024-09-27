package proxy;

public class Employ {
    private String name;
    private String rfc;
    private String area;
    private short floor;

    public Employ(String name, String rfc, String area, short floor) {
        this.name = name;
        this.rfc = rfc;
        this.area = area;
        this.floor = floor;
    }
    public String getName() {
        return name;
    }
    public String getRfc() {
        return rfc;
    }
    public String getArea() {
        return area;
    }
    public short getFloor() {
        return floor;
    }
}
