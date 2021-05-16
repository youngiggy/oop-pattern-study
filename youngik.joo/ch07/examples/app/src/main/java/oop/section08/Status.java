package oop.section08;

class Status {
    private boolean isNormal = true;

    public void setNormal(boolean isNormal) {
        this.isNormal = isNormal;
    }

    public boolean isNotNormal() {
        return !isNormal;
    }
}
