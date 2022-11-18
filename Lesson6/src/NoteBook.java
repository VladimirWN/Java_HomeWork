public class NoteBook {

    private String name;
    private String model;
    private double screenSize;
    private String matrixType;
    private String processorModel;
    private int ramSize;
    private int hddSize;
    private boolean preinstalledOS;

    public NoteBook(String name, String model, double screenSize, String matrixType, String processorModel, int ramSize, int hddSize, boolean preinstalledOS) {
        this.name = name;
        this.model = model;
        this.screenSize = screenSize;
        this.matrixType = matrixType;
        this.processorModel = processorModel;
        this.ramSize = ramSize;
        this.hddSize = hddSize;
        this.preinstalledOS = preinstalledOS;
    }

    public String getNeedField(Integer i) {
        if (i == 1) return String.valueOf(getScreenSize());
        if (i == 2) return getMatrixType();
        if (i == 3) return getProcessorModel();
        if (i == 4) return String.valueOf(getRamSize());
        if (i == 5) return String.valueOf(getHddSize());
        if (i == 6) return isPreinstalledOS() ? "Yes" : "No";
        return null;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s, size: %.1f, matrix: %s, processor %s, RAM: %d GB, HDD: %d GB, Preinstalled OS: %s\n",
        this.name, this.model, this.screenSize, this.matrixType, this.processorModel, this.ramSize, this.hddSize,
                this.preinstalledOS ? "YES" : "NO");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getMatrixType() {
        return matrixType;
    }

    public void setMatrixType(String matrixType) {
        this.matrixType = matrixType;
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String processorModel) {
        this.processorModel = processorModel;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getHddSize() {
        return hddSize;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public boolean isPreinstalledOS() {
        return preinstalledOS;
    }

    public void setPreinstalledOS(boolean preinstalledOS) {
        this.preinstalledOS = preinstalledOS;
    }
}
