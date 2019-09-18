package app.saikat.GsonManagement.Test_2;

public class TestType {

    private String str;
    private int val;

    public TestType(String str, int val) {
        this.str = str;
        this.val = val;
    }

    public String getStr() {
        return this.str;
    }

    public int getVal() {
        return this.val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TestType) {
            TestType tt = (TestType) obj;
            return str.equals(tt.getStr()) && val == tt.getVal();
        } else {
            return false;
        }
    }
    
}