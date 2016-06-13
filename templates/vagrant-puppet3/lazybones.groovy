def props = [:]
props.configVmBox = ask("Define value for 'config.vm.box' [boxcutter/ubuntu1404]: ", "boxcutter/ubuntu1404", "configVmBox")

processTemplates "Vagrantfile", props

