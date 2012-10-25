reports {
    "boms.txt" {
        title = "BOMs"
        description = "Bill-of-Materials POMs referenced by the POMs in the repository, with status on each MANAGED dependency they provide"
    }
    "build-requires.txt" {
        title = "Build Requirements"
        description = "Anything required to build the project EXCEPT for those things included in the Requirements report"
    }
    "requires.txt" {
        title = "Requirements"
        description = "These are runtime requirements including runtime-scoped (or implied runtime-scoped) dependencies and parent POMs"
    }
    "inverse-requires.txt" {
        title = "Inverted Requirements"
        description = "Lists all projects that have a runtime requirement on the project in question, and the nature of that requirement"
    }
    "inverse-build-requires.txt" {
        title = "Inverted Build Requirements"
        description = "Lists all projects that have a build-time requirement on the project in question, and the nature of that requirement. This report EXCLUDES any information that overlaps the 'Inverted Requirements' report."
    }
    "inverse-missing-requires.txt" {
        title = "Inverted Missing Requirements"
        description = "For all projects listed as MISSING (unresolvable, or unreadable due to a parsing error), list all projects that have a runtime requirement on this project."
    }
    "inverse-missing-build-requires.txt" {
        title = "Inverted Missing Build Requirements"
        description = "Same as 'Inverted Build Requirements' except that, as with 'Inverted Missing Requirements', it only lists projects that failed to build / resolve."
    }
    "processed.txt" {
        title = "Processed Projects"
        description = "All POMs visited by the validator, whether or not they were resolvable / buildable"
    }
    "missing.txt" {
        title = "Missing Projects"
        description = "All POMs that could not be resolved / parsed by the validator. For unresolvable projects, they must have been referenced by another project, since the validator's point of entry is a file-scan of the repository that looks for POM files."
    }
    "valid.txt" {
        title = "Valid Projects"
        description = "Processed - Missing == Projects that were resolvable and parsable (and referenced or present in the file scan)."
    }
    "models-with-failure.txt" {
        title = "Model Errors & Failures"
        description = "For each MISSING / broken POM, list the errors and parsing / validation problems that came up when the validator tried to load it."
    }

}