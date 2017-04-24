// -*- mode: groovy -*-
// vi: set ft=groovy :

@Grab(group="uk.co.cacoethes", module="groovy-handlebars-engine", version="0.2")
import uk.co.cacoethes.handlebars.HandlebarsTemplateEngine

def toBoolean(String val) {
  val = val.toLowerCase()
  if (val.startsWith("n") || val.equals("false")) {
    return ''
  } else {
    return val
  }
}

registerDefaultEngine new HandlebarsTemplateEngine()

def props = [:]
props.usePuppetCollection = toBoolean(ask("Use Puppet Collections (aka Puppet 4) [Y/n]): ", "Y", "usePuppetCollection"))
props.puppetCollection = ""
defaultBox = "boxcutter/ubuntu1404"
if (props.usePuppetCollection) {
  props.puppetCollection = ask("Define value for 'PUPPET_COLLECTION' [pc1]: ", "pc1", "puppetCollection")
  defaultBox = "boxcutter/ubuntu1604"
}

props.configVmBox = ask("Define value for 'config.vm.box' [${defaultBox}]: ", defaultBox, "configVmBox")

processTemplates "Vagrantfile", props
processTemplates "**/Puppetfile", props
processTemplates "**/environment.conf", props
processTemplates "**/hiera.yaml", props
processTemplates "**/*.pp", props
