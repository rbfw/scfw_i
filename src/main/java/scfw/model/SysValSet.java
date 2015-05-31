package scfw.model;

public class SysValSet {
    private Integer id;

    private String valSetCode;

    private String val;

    private String valCn;

    private String valEn;

    private Integer isDeleted;

    private Integer parentId;

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

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    public String getValCn() {
        return valCn;
    }

    public void setValCn(String valCn) {
        this.valCn = valCn == null ? null : valCn.trim();
    }

    public String getValEn() {
        return valEn;
    }

    public void setValEn(String valEn) {
        this.valEn = valEn == null ? null : valEn.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}