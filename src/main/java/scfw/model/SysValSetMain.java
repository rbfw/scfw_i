package scfw.model;

public class SysValSetMain {
    private Integer id;

    private String valSetCode;

    private String valSetName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValSetCode() {
        return valSetCode;
    }

    public void setValSetCode(String valSetCode) {
        this.valSetCode = valSetCode == null ? null : valSetCode.trim();
    }

    public String getValSetName() {
        return valSetName;
    }

    public void setValSetName(String valSetName) {
        this.valSetName = valSetName == null ? null : valSetName.trim();
    }
}