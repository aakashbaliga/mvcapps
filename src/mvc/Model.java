package mvc;

public class Model extends Publisher {

    boolean unsavedChanges = false;
    String fileName = null;

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fName) {
        fileName = fName;
    }

    public void changed() {
        unsavedChanges = true;
    }

    public void setUnsavedChanges(boolean b) {
        unsavedChanges = b;
    }
}
