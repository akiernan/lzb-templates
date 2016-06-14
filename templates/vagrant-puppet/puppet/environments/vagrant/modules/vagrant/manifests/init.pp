class vagrant {
  Class['apt::update'] -> Package <| provider == 'apt' |>

{{#puppetCollection}}
  $packages = lookup('packages', Array[String], 'unique', [])
{{/puppetCollection}}
{{^puppetCollection}}
  $packages = hiera_array('packages', [])
{{/puppetCollection}}
  package { $packages:
    ensure => present
  }
}
