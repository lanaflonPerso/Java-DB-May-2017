package cars.dto.bindings;

import com.google.gson.annotations.Expose;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public class SupplierImportDto {

    @Expose
    private String name;

    @Expose
    private boolean isImporter;

    public SupplierImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return this.isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
