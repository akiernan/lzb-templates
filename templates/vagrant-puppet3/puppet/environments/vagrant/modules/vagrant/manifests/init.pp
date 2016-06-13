class vagrant {
  Class['apt::update'] -> Package <| provider == 'apt' |>

  $packages = hiera_array('packages', [])
  package { $packages:
    ensure => present
  }
}
