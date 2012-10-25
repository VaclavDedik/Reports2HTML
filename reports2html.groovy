class Main {

    static input
    static output

    static initReports(String reportsConfig) {
        def reports = new ConfigSlurper().parse(
                            new File(reportsConfig).toURL()
                            )["reports"]
        reports.each { key, value ->
            reports[key].content = new File("${input}/${key}").getText()
            reports[key].link = "reports/${key}.html"
        }
        reports
    }

    static main(String[] args) {
        def argsList = args as List
        input = argsList[0] ? argsList[0] : "input"
        output = argsList[1] ? argsList[1] : "output"

        new File("${output}").mkdir()
        new File("${output}/reports").mkdir()

        def reports = initReports("reports.groovy")

        reports.each {key, value ->
            def reportBodyPage = new HtmlPage(
                    templatePath: "templates/report-body.html",
                    model: value + [link: "../index.html"]
                )
            def reportPage = new HtmlPage(
                    templatePath: "templates/template.html",
                    model: [title: value.title, body: reportBodyPage]
                )
            def outputFile = new File("${output}/${value.link}")
            outputFile.createNewFile()
            outputFile.write(reportPage.toString())
        }

        def indexBodyPage = new HtmlPage(
                templatePath: "templates/index-body.html",
                model: [title: "Reports", reports: reports]
            )

        def indexPage = new HtmlPage(
                templatePath: "templates/template.html",
                model: [title: "Reports", body: indexBodyPage]
            )

        def outputIndexFile = new File("${output}/index.html")
        outputIndexFile.createNewFile()
        outputIndexFile.write(indexPage.toString())
    }
}