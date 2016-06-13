def props = [:]
props.configVmBox = ask("Define value for 'config.vm.box' [boxcutter/ubuntu1604]: ", "boxcutter/ubuntu1604", "configVmBox")
props.puppetCollection = ask("Define value for 'PUPPET_COLLECTION' [pc1]: ", "pc1", "puppetCollection")

processTemplates "Vagrantfile", props

