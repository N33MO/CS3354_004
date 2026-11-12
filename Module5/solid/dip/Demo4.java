package Module5.solid.dip;

public class Demo4 {
    
}


/**
 * The class below violates DIP. Given the design requirements, how 
 * would you refactor it?
 * 
 * 1. The team needs to support CSV export in addition to PDF, 
 * selectable at runtime.
 * 
 * 2. During testing, report generation should not produce real files — 
 * a mock exporter is needed.
 * 
 * 3. An HTMLExporter will be added in the future without modifying 
 * ReportGenerator.
 * 
 * 4. ReportGenerator should have no knowledge of any specific export 
 * format.
 */

// BEFORE
class PDFExporter {
    public void export(String content) {
        System.out.println("Exporting to PDF: " + content);
    }
}
class ReportGenerator {
    private PDFExporter exporter = new PDFExporter();                   // hardcoded

    public void generateReport(String data) {
        String report = "Report: " + data;
        System.out.println("Generating report...");
        exporter.export(report);
    }
}

// AFTER
interface IExporter { void export(String content); }

class PDFExporter implements IExporter {
  public void export(String content) {
    System.out.println("PDF: " + content);
  }
}

class CSVExporter implements IExporter {
  public void export(String content) {
    System.out.println("CSV: " + content);
  }
}

class MockExporter implements IExporter {
  public void export(String content) {
    System.out.println("Mock: " + content);
  }
}

class ReportGenerator {
  private IExporter exporter;

  // Dependency injected — no "new" here
  public ReportGenerator(IExporter exporter) {
    this.exporter = exporter;
  }

  public void generateReport(String data) {
    String report = "Report: " + data;
    System.out.println("Generating...");
    exporter.export(report);
  }
}

// Production — export as PDF
new ReportGenerator(new PDFExporter())
    .generateReport("Q4 Sales");

// Production — export as CSV
new ReportGenerator(new CSVExporter())
    .generateReport("Q4 Sales");

// Testing — no real files created
new ReportGenerator(new MockExporter())
    .generateReport("Q4 Sales");

// Future — HTMLExporter added with
// zero changes to ReportGenerator