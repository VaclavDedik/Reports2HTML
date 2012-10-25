import groovy.text.TemplateEngine
import groovy.text.GStringTemplateEngine

class HtmlPage {
    def engine = new GStringTemplateEngine()

    def model

    def templatePath

    String toString() {
        engine.createTemplate(new File(templatePath)).make(model).toString()
    }
}