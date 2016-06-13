class vagrant {
  Class['apt::update'] -> Package <| provider == 'apt' |>

  $packages = lookup('packages', Array[String], 'unique', [])
  package { $packages:
    ensure => present
  }
}
